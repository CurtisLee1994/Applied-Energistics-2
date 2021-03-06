/*
 * This file is part of Applied Energistics 2.
 * Copyright (c) 2013 - 2015, AlgorithmX2, All rights reserved.
 *
 * Applied Energistics 2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Applied Energistics 2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Applied Energistics 2.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */

package appeng.util.inv;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.ITextComponent;

import appeng.integration.IntegrationRegistry;
import appeng.integration.IntegrationType;
import appeng.integration.abstraction.IBuildCraftTransport;


public class WrapperBCPipe implements IInventory
{
	private final IBuildCraftTransport bc;
	private final TileEntity ad;
	private final EnumFacing dir;

	public WrapperBCPipe( final TileEntity te, final EnumFacing d )
	{
		this.bc = (IBuildCraftTransport) IntegrationRegistry.INSTANCE.getInstance( IntegrationType.BuildCraftTransport );
		this.ad = te;
		this.dir = d;
	}

	@Override
	public int getSizeInventory()
	{
		return 1;
	}

	@Override
	public ItemStack getStackInSlot( final int i )
	{
		return null;
	}

	@Override
	public ItemStack decrStackSize( final int i, final int j )
	{
		return null;
	}

	@Override
	public ItemStack removeStackFromSlot( final int i )
	{
		return null;
	}

	@Override
	public void setInventorySlotContents( final int i, final ItemStack itemstack )
	{
		if( IntegrationRegistry.INSTANCE.isEnabled( IntegrationType.BuildCraftTransport ) )
		{
			this.bc.addItemsToPipe( this.ad, itemstack, this.dir );
		}
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public void markDirty()
	{

	}

	@Override
	public void openInventory( final EntityPlayer player )
	{

	}

	@Override
	public void closeInventory( final EntityPlayer player )
	{

	}

	@Override
	public boolean isUseableByPlayer( final EntityPlayer entityplayer )
	{
		return false;
	}

	@Override
	public boolean isItemValidForSlot( final int i, final ItemStack itemstack )
	{
		return this.bc.canAddItemsToPipe( this.ad, itemstack, this.dir );
	}

	@Override
	public int getField( final int id )
	{
		return 0;
	}

	@Override
	public void setField( final int id, final int value )
	{

	}

	@Override
	public int getFieldCount()
	{
		return 0;
	}

	@Override
	public void clear()
	{

	}

	@Override
	public String getName()
	{
		return null;
	}

	@Override
	public boolean hasCustomName()
	{
		return false;
	}

	@Override
	public ITextComponent getDisplayName()
	{
		return null;
	}
}
